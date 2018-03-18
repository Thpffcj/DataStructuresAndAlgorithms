package algorithms.algorithmGame.sortVisualization.twoWaysQuickSortVisualization;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Thpffcj on 2017/10/10.
 */
public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    // data
    private TwoWaysQuickSortData data;
    public void render(TwoWaysQuickSortData data){
        this.data = data;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            int w = canvasWidth/data.N();
            for(int i = 0 ; i < data.N() ; i ++ ) {
                if ( i >= data.l && i <= data.r)
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Green);
                else
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);

                if( i == data.curPivot )
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Indigo);
                if( i >= data.l + 1 && i <= data.curL)
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                if( i >= data.curR && i <= data.r)
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.LightBlue);
                if( data.fixedPivots[i] )
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);

                AlgoVisHelper.fillRectangle(g2d, i * w, canvasHeight - data.get(i), w - 1, data.get(i));
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}