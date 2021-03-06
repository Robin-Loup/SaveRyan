#include <MLV/MLV_all.h>

#define LINE_COLOR MLV_COLOR_BLUE
#define BACKGROUND_COLOR MLV_COLOR_WHITE

int main() {

	/* Create the window */
	MLV_create_window("Draw", "Draw", 500, 500);
	MLV_draw_filled_rectangle(0, 0, 499, 499, BACKGROUND_COLOR);

	/* Draw the letter A */

	MLV_draw_line(200, 300, 250, 200, LINE_COLOR);
	MLV_draw_line(300, 300, 250, 200, LINE_COLOR);
	MLV_draw_line(225, 250, 275, 250, LINE_COLOR);
	MLV_update_window();

	/* Wait and quit */

	MLV_wait_seconds(5);
	MLV_free_window();

	return 0;
}