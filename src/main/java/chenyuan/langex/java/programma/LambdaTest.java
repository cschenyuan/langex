package chenyuan.langex.java.programma;


interface StateChangeListener {
  public void onStateChange(String oldState,String newState);
}

class StateOwner {

  public void addStateListener (StateChangeListener listener) {
    listener.onStateChange("OK","FALSE");
  }
}

public class LambdaTest {
  public static void main(String[] args) {
    StateOwner owner = new StateOwner();

    // in Java < 8
    owner.addStateListener(new StateChangeListener(){
      public void onStateChange(String oldState,String newState) {
        System.out.println("State Changed");
      }
    });

    // lambda supported in Java 8
    owner.addStateListener(
        (oldState, newState) -> System.out.println("State Changed")
    );
  }

}
