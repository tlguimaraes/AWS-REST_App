package com.thiagoleoncio.trial.weather;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A collected point, including some information about the range of collected
 * values
 *
 * @author Thiago L Guimaraes
 */
// CR: formatted the class
public class DataPoint {

	// CR: restrict the access modifier of member variable
	private double mean = 0.0;

	private int first = 0;

	private int second = 0;

	private int third = 0;

	private int count = 0;

	/** private constructor, use the builder to create this object */
	private DataPoint() {
	    super();
	}

	protected DataPoint(int first, int second, int mean, int third, int count) {
		this.setFirst(first);
		this.setMean(mean);
		this.setSecond(second);
		this.setThird(third);
		this.setCount(count);
	}

	/** the mean of the observations */
	public double getMean() {
		return mean;
	}

	protected void setMean(double mean) {
		this.mean = mean;
	}

	/** 1st quartile -- useful as a lower bound */
	public int getFirst() {
		return first;
	}

	protected void setFirst(int first) {
		this.first = first;
	}

	/** 2nd quartile -- median value */
	public int getSecond() {
		return second;
	}

	protected void setSecond(int second) {
		this.second = second;
	}

	/** 3rd quartile value -- less noisy upper value */
	public int getThird() {
		return third;
	}

	protected void setThird(int third) {
		this.third = third;
	}

	/** the total number of measurements */
	public int getCount() {
		return count;
	}

	protected void setCount(int count) {
		this.count = count;
	}

	// CR: override recommended
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
	}

	// CR: override and hascode method is recommended for equals
	@Override
	public boolean equals(Object that) {
		return this.toString().equals(that.toString());
	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

	//CR: Reordered access modifiers
 public static class Builder {
		int first;
		int mean;
		int median;
		int last;
		int count;

		//CR: empty constructor is not required
		//public Builder() {
		//}

		public Builder withFirst(int first) {
			//CR: this operator is recommended for better readability
			this.first = first;
			return this;
		}

		public Builder withMean(int mean) {
			//CR: this operator is recommended for better readability
			this.mean = mean;
			return this;
		}

		public Builder withMedian(int median) {
			//CR: this operator is recommended for better readability
			this.median = median;
			return this;
		}

		public Builder withCount(int count) {
			//CR: this operator is recommended for better readability
			this.count = count;
			return this;
		}

		public Builder withLast(int last) {
			//CR: this operator is recommended for better readability
			this.last = last;
			return this;
		}

		public DataPoint build() {
			return new DataPoint(this.first, this.mean, this.median, this.last, this.count);
		}
	}
}
