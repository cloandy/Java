import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame{
    public void LaunchFrame(){
        setTitle("小作品");
        setVisible(true);
        setSize(500, 500);
        setLocation(300, 300);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.LaunchFrame();
    }
}