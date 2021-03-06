#include "grid.h"
#include <stdlib.h>


/*
 * Allocate memory for a grid and initialize each cell.
 */
grid *create_grid(int x_size, int y_size) {
	int i, j;
	grid *g = (grid *)malloc(sizeof(grid));
	g->x_size = x_size;
	g->y_size = y_size;
	g->cells = (cell **)malloc(x_size*sizeof(cell *));
	for (i = 0; i < x_size; i++)
		g->cells[i] = (cell *)malloc(y_size*sizeof(cell));

	for (j = 0; j < y_size; j++)
		for (i = 0; i < x_size; i++) {
			g->cells[i][j].x_pos = i;
			g->cells[i][j].y_pos = j;
			g->cells[i][j].visible = 0;
			g->cells[i][j].marked = 0;
			g->cells[i][j].mine = 0;
			g->cells[i][j].mine_count = 0;
		}

	return g;
}

/*
 * Free memory for a grid.
 */
void free_grid(grid *g) {
	int i;
	for (i = 0; i < g->x_size; i++)
		free(g->cells[i]);
	free(g->cells);
	free(g);
}

/*
 * Set all cells to visible (for debugging).
 */
void set_all_visible(grid *g) {
	int x, y;
	for (x = 0; x < g->x_size; x++)
		for (y = 0; y < g->y_size; y++)
			g->cells[x][y].visible = 1;
}

/*
 * Add exactly n mines to grid g in random positions.
 */
void add_mines_count(grid*g, int x, int y){
	int i, j;
	for (i = x-1; i <= x+1; i++)
	{
		for (j = y-1; j <= y+1; j++)
		{
			if ((i != x || j != y) && i >= 0 &&  j >= 0 && i < g->x_size && j < g->y_size)
			{
				g->cells[i][j].mine_count++;
			}
		}
	}
}

void add_mines(grid *g, int n) {
	int compteur, x, y;
	for (compteur = 0; compteur < n; compteur++)
	{
		x = rand()%g->x_size;
		y = rand()%g->y_size;
		if (g->cells[x][y].mine == 1)
		{
			compteur--;
		}
		else{
			g->cells[x][y].mine = 1;
			add_mines_count(g, x, y);
		}
	}
	return;
}



/*
 * Uncover cell c in grid g.
 * Return the total number of cells uncovered.
 */
int uncover(grid *g, cell *c) {
	int i, j, result;
	if (c->visible == 1 || c->marked == 1)
	{
		return 0;
	}
	else{
		c->visible = 1;
		draw_cell_actualise_window(c);
		if (c->mine == 1 || c->mine_count != 0)
		{	
			return 1;
		}
		else{
			result = 1;
			for (i = c->x_pos-1; i <= c->x_pos+1; i++)
			{
				for (j = c->y_pos-1; j <= c->y_pos+1; j++)
				{
					if ((i != c->x_pos || j != c->y_pos) && i >= 0 &&  j >= 0 && i < g->x_size && j < g->y_size)
					{
						result += uncover(g, &g->cells[i][j]);
					}
				}
			}
			return result;
		}	
	}
}
