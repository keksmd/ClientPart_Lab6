package commands.types;

public class ValueArgumented extends ElementAndValueArgumented {

    public ValueArgumented(String v) {

        super(v,null);
    }

    @Override
    public ValueArgumented elFactory(String v, String[] args) {
        return new ValueArgumented(v).elFactory(v,null);
    }

    public static ValueArgumented newInstance(String v){
        return new ValueArgumented(v).elFactory(v,null);
    }


    public ValueArgumented elFactory(String v) {
        return new ValueArgumented(v);
    }
}