import gpdraw.*;
import java.awt.Color;
public class Flower
//John ghantous
{
    int x;
    int y;
    private SketchPad pad;
    private DrawingTool pen;

    public Flower(int x, int y){
        this.x = x;
        this.y = y;
        pad=new SketchPad(x,y);
        pen=new DrawingTool(pad);
        pen.setWidth(1);
    }

    public void draw(int count,double length, double xPos, double yPos, boolean b){
        double x;
        double y;
        pen.setWidth(1);
        if (count==1)
        {
            pen.drawCircle(length);
        }

        else {
            pen.setColor(Color.BLUE);
            if(b) pen.setColor(new Color(250,0,250));
            pen.up();
            pen.move(xPos, yPos);
            pen.down();
            pen.drawCircle(length);
            x=  pen.getXPos();
            y = pen.getYPos();

            pen.up();
            pen.setColor(Color.RED);
            if(b) {pen.move(xPos-2*length, yPos);}
            else pen.move(xPos+2*length, yPos);            
            pen.down();
            pen.drawCircle(length);
            
            pen.up();
            pen.setColor(Color.ORANGE);
            //if(b) pen.setColor(Color.RED);
            pen.move(xPos, -yPos);            
            pen.down();
            pen.drawCircle(length);
            
            pen.up();
            pen.setColor(Color.BLACK);
            if(b==true) pen.move(xPos-2*length, -yPos);
            else pen.move(xPos+2*length, -yPos);            
            pen.down();
            pen.drawCircle(length);
            
            draw(count-1, length-length/count, x-x/count, y-y/count, b);
            
        }
    }
    public void drawTop(double x, double y, int count, double length)
    {
        if(count==1) pen.drawCircle(length);
        if(x<1) x=1;
        if(y<1) y=1;
        pen.up();
        pen.move(x,y);
        pen.setColor(Color.BLACK);
        pen.setWidth(2);
        pen.down();
        pen.drawCircle(length+1);
        
        pen.up();
        pen.move(x,-y);
        pen.setColor(Color.BLACK);
        pen.down();
        pen.drawCircle(length);
        
        drawTop(x, y-y/count, count-1, length-length/count);
    }
    public void drawStem()
    {
        pen.up();
        pen.move(0,-80);
        pen.down();
        pen.setWidth(7);
        pen.setColor(Color.GREEN);
        pen.move(0,-600);
        
    }
    public void drawBack(int count, int x,int y, int r)
    {
        if(count==1) pen.drawCircle(r);
         pen.up();
        pen.move(x,y);
         pen.down();
        pen.setColor(Color.YELLOW);
         pen.setWidth(3);
         pen.drawCircle(r);
        drawBack(count-1, x, y-2, r-5);
        
    }
}
