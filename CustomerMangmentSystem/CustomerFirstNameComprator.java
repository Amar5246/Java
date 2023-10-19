package utils;

import java.util.Comparator;

import Classes.CustMangment;

public class CustomerFirstNameComprator implements Comparator<CustMangment>{

	@Override
	public int compare(CustMangment o1, CustMangment o2) {
		return o1.getFirst_name().compareTo(o2.getFirst_name());
	}

}
