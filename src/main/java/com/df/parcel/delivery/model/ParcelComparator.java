package com.df.parcel.delivery.model;

import java.util.Comparator;

/**
 * Defines the ordering of the parcels.
 *
 * @author bilalwahla
 */
public class ParcelComparator implements Comparator<Parcel> {
  @Override
  public int compare(Parcel o1, Parcel o2) {
    if (o1.getPriority() > o2.getPriority())
      return 1;
    else if (o1.getPriority() == o2.getPriority())
      return 0;
    else return -1;
  }
}
