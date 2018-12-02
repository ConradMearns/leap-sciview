package sc.iview.leap;

// import sc.iview.SciViewService;
// import sc.iview.SciView;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Controller;

import net.imagej.ImageJService;
// import net.imagej.mesh.Mesh;

import sc.iview.vector.ClearGLVector3;
import sc.iview.vector.Vector3;

import sc.iview.SciView;

import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.service.Service;
import org.scijava.service.AbstractService;
import org.scijava.log.LogService;
import org.scijava.Context;

import graphics.scenery.Node;
import cleargl.GLVector;

@Plugin(type = Service.class)
public class LeapService extends AbstractService implements ImageJService{

  LeapPlugin plugin;

  @Parameter
  private Context context;

  @Override
  public void initialize() {
    plugin = new LeapPlugin();
    context.inject(plugin);
    plugin.init();
  }

  @Plugin(type = Service.class)
  public class LeapPlugin {
    protected Node rightHand;
    protected Node leftHand;

    private LeapListener listener;
    private Controller controller;

    @Parameter
    public SciView sciView;

    @Parameter
    private LogService logService;

    public void init() {
      System.out.println("\n\n\ntttt: "+plugin.sciView);

      listener = new LeapListener(this);
      controller = new Controller();
      controller.addListener(listener);
    }

  }

  public class LeapListener extends Listener {

    private LeapPlugin plugin;

    public LeapListener(LeapPlugin plugin) {
      this.plugin = plugin;
    }

      public void onConnect(Controller controller) {
          System.out.println("Connected");
      }

      public void onFrame(Controller controller) {
        Frame frame = controller.frame();
        // System.out.println("hands: " + frame.hands().count() + ", fingers: " + frame.fingers().count());

        System.out.println("t: "+plugin.sciView);
        if (plugin.sciView != null) {
          Vector3 pos = ClearGLVector3.parse("0; 0; 0");
          Vector3 vSize = new ClearGLVector3(5.0f, 5.0f, 5.0f);
          plugin.rightHand = plugin.sciView.addBox(pos, vSize, SciView.DEFAULT_COLOR, false);
        }

        if (frame.hands().count() > 0) {
          for (Hand hand : frame.hands()) {
            if(hand.isRight()) {
              float x = hand.palmPosition().getX();
              float y = hand.palmPosition().getY();
              float z = hand.palmPosition().getZ();
              plugin.rightHand.setPosition(new GLVector(x, y, z));
            }
          }
        }


      }
  }
}
