package sc.iview.leap;

// import sc.iview.SciViewService;
// import sc.iview.SciView;

import net.imagej.ImageJService;

import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.service.Service;
import org.scijava.service.AbstractService;

@Plugin(type = Service.class)
public class LeapService extends AbstractService implements ImageJService{

  @Override
  public void initialize() {
    System.out.println("aahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
  }

}
