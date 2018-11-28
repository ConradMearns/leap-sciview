package sc.iview.leap;

// import sc.iview.SciViewService;
// import sc.iview.SciView;

import com.leapmotion.leap.*;
import com.leapmotion.leap.Controller;

import net.imagej.ImageJService;

import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.service.Service;
import org.scijava.service.AbstractService;

@Plugin(type = Service.class)
public class LeapService extends AbstractService implements ImageJService{

  @Override
  public void initialize() {
    Controller controller = new Controller();
  }

}
