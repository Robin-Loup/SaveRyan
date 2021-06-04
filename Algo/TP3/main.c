#include "tp3.h"


int main(){
    /******Exercice 1******/
    /* Create the window */
	MLV_create_window("Draw", "Draw", 1000, 1000);
	MLV_draw_filled_rectangle(0, 0, 999, 999, BACKGROUND_COLOR);

    /* Draw the letter A */
    H(500, 500, 400);
    
    /* Wait and quit */

	MLV_wait_seconds(10);
	MLV_free_window();

	return 0;
}