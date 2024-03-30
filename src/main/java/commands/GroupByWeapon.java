package commands;
import main.Command;
import utilites.interfaces.methods;
public class GroupByWeapon extends Command implements methods{

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private String name = "group_counting_by_weapon_type" ;
}
