#include "tp3.h"

/******Exercice 1******/
void H(int x, int y, int largeur){
    MLV_draw_line(x-largeur/2, y, x+largeur/2, y, LINE_COLOR);
    MLV_wait_seconds(0.9); 
    MLV_draw_line(x-largeur/2, y-largeur/2, x-largeur/2, y+largeur/2, LINE_COLOR);
    MLV_wait_seconds(0.9); 
    MLV_draw_line(x+largeur/2, y-largeur/2, x+largeur/2, y+largeur/2, LINE_COLOR);
    MLV_wait_seconds(0.9);
    MLV_update_window(); 
    if (largeur >= 8)
    {
        H(x+largeur/2, y-largeur/2,largeur/2);
        H(x-largeur/2, y-largeur/2,largeur/2);
        H(x-largeur/2, y+largeur/2,largeur/2);
        H(x+largeur/2, y+largeur/2,largeur/2);
    }
    
    
}
