package fudbalskaliga;

import java.util.Comparator;

public class Uporedi implements Comparator<FudbalskiKlub> {
	
	@Override
    public int compare(FudbalskiKlub t, FudbalskiKlub t1) {
        
        if(t.getPoeni() > t1.getPoeni()) 
            return -1;
        else 
            if (t.getPoeni() < t1.getPoeni())
                return 1;
            else {
                int golRazlika = t.getPostignutiGolCount()-t.getPrimljeniGolCount();
                int golRazlika1 = t1.getPostignutiGolCount()-t1.getPrimljeniGolCount();
                if(golRazlika > golRazlika1)
                    return -1;
                else
                    if(golRazlika < golRazlika1)
                        return 1;
                    else return 0;
            }
        
    }

}
