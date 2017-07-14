package com.df.parcel.delivery.model;

/**
 * Parcel information.
 *
 * @author bilalwahla
 */
public class Parcel {
  private long id;

  private int priority;

  public Parcel(long id, int priority) {
    this.id = id;
    this.priority = priority;
  }

  public long getId() {
    return id;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public String toString() {
    return "Parcel{" +
        "id=" + id +
        ", priority=" + priority +
        '}';
  }
}
