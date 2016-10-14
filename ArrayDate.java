public class ArrayDate {
	public static void main (String args[]) {
		int length = 5;
		Date[] d = new Date[length];
		d[0] = new Date (2008, 7, 31);
		d[1] = new Date (2008, 9, 30);
		d[2] = new Date (2016, 8, 2); 	
		d[3] = new Date (1999, 7, 1); 	
		d[4] = new Date (2009, 6, 7); 	
		
		// sortDateSmall2Big (d);
		printDate (d);
		// sortDateBig2Small(d);
		// printDate (d);
		
		Date target = new Date (2016, 8, 2);
		System.out.println ("To find Year/ month / day: " + target.year + " " + target.month + " " + target.day);		
		
		int result = findDate (d, target);
		if (  result != -1)
			System.out.println ("The date is within the date array: d[" + result + "].");	
		else 		
			System.out.println ("NOT FOUND.");	
	}
	
	static void sortDateSmall2Big(Date[] d) { //from small to big date using bubbling sort
		for (int iteration = 0; iteration < d.length; iteration++) {
			int end = d.length - iteration;
			boolean swapped = false;
			for (int j = 0; j < end - 1; j ++) {
				if (d[j].compare (d [j+1]) == 1) {
					Date temp = d [j];
					d [j] = d [j+1];
					d [j+1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				// System.out.println ("Termination on iteration: " + (iteration+1));		
				break;
			}
		}
		System.out.println ("Finish sorting from small to big.");			
	}
	
	static void sortDateBig2Small(Date[] d) { //from big to small date using bubbling sort
		for (int iteration = 0; iteration < d.length; iteration++) {
			int end = d.length - iteration;
			boolean swapped = false;
			for (int j = 0; j < end - 1; j ++) {
				if (d[j].compare (d [j+1]) == 0) {
					Date temp = d [j];
					d [j] = d [j+1];
					d [j+1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				// System.out.println ("Termination on iteration: " + (iteration+1));		
				return;
			}
		}
		System.out.println ("Finish sorting from big to small.");		
	}
	
	static void printDate( Date[] d) {
		for (int i = 0; i < d.length; i++) {
			System.out.println ("Year/ month / day: " + d[i].year + " " + d[i].month + " " + d[i].day);		
		}
	}
	
	static int findDate(Date[] d, Date someday) { // binarySearch 
		int initial = 0, end = d.length - 1, middle = (initial + end) / 2;
				
		if (d.length <= 0) {
			System.out.println ("The array is empty, please check!");		
			return -1; 
		}
		
		sortDateSmall2Big (d);
		// sortDateBig2Small (d);
		printDate (d);
		
		while (end >= initial) {
			if ( someday.compare (d[middle]) == -1 )
				return middle;
			if (someday.compare (d[middle]) == 1) 
				initial = middle + 1;
			if (someday.compare (d[middle]) == 0)
				end = middle - 1; 
			
			middle = (end + initial) / 2;
		}
		return -1;		
	}	
}

class Date {
	int year = 0, month = 0, day = 0;
	
	Date (int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	int compare (Date d) {
		return this.year > d.year ? 1 
			:this.year < d.year ? 0
			:this.month > d.month ? 1
			:this.month < d.month ? 0
			:this.day > d.day ? 1
			:this.day < d.day ? 0: -1;
	}
}
