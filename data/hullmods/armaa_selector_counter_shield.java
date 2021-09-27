package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.combat.ShieldAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShieldAPI.ShieldType;

public class armaa_selector_counter_shield extends BaseHullMod {

	private static final float SHIELD_MALUS = -50f;
	public static final float SHIELD_BONUS_TURN = 100f;
	public static final float SHIELD_BONUS_UNFOLD = 100f;

	
	  @Override
    	  public int getDisplaySortOrder() 
	  {
        	return 2000;
    	  }

  	  @Override
  	  public int getDisplayCategoryIndex() 
	  {
		return 3;
    	  }

	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) 
	{
		stats.getShieldArcBonus().modifyPercent(id, SHIELD_MALUS);
		stats.getShieldTurnRateMult().modifyPercent(id, SHIELD_BONUS_TURN);
		stats.getShieldUnfoldRateMult().modifyPercent(id, SHIELD_BONUS_UNFOLD);
		
	}
	
	public void applyEffectsAfterShipCreation(ShipAPI ship, String id) {
		ShieldAPI shield = ship.getShield();
		if (shield != null) {
			shield.setType(ShieldType.OMNI);
		}
	}
	
    @Override
    public String getDescriptionParam(int index, ShipAPI.HullSize hullSize) {
 		if (index == 0) return "XCS-03 Counter Shield";
		if (index == 1) return "Remove this hullmod to cycle between cores.";
        return null;    
    }

}
