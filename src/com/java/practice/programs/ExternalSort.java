package com.java.practice.programs;

/*Sorting is a fundamental programming task.Given the abundance of built-in libraries that perform tasks like sorting and binary search,we often become 
 forgetful of exactly how these tasks are accomplished.

When the data is so large that it cannot be processed in memory at one time we need to resort to the file system to store part or all the data during 
the sorting process.We then need to perform another layer of disk operations on top of regular sorting algorithms to manage the data as they get sorted.

External Sorting is precisely the technique we described in the previous paragraph.

Let us describe in some detail how external sorting can be done in Java:

First the algorithm:

Say,we have one file(it can be more than one file,but having just one file simplifies the process for illustration purpose)in disk containing N numbers.
And suppose the memory in our computer can hold M numbers at a time.

1. Start reading the input file from the beginning.
2. Read M(or less if number of entries remaining in the file is less than M)numbers from the file and store it into a temp buffer.
3. Sort(using any good sorting method-Quicksort,for example)the numbers in the buffer stored in step 2. 
4. Create a temp file in disk and write out the sorted numbers from step 3 to this temp file.Save the name of the temp file.
5. Repeat step 2 to 4 until all numbers from the input file has been read,sorted,and written out to temp files.

At this point,we have chunks of numbers of size M sorted and stored in temp files in disk.We need to merge all these sorted files into one single sorted file.
We will apply the merging algorithm from Merge Sort to join the numbers from these sorted files together.

6. Open all the temp files(and set the read pointer to the beginning of the files).
7. Find the minimum number from the set of numbers currently pointed to by the file read pointer.
8. Write the number to disk.(To increase efficiency you could write the number to a buffer first and then flush the buffer out to disk when the buffer is full.
But modern I/O libraries should be doing this anyway for you).
9. Read another number from the file that contained the minimum number at step 7. 
10. Repeat step 7 to 9 until all numbers from all the temp files have been processed,merged,and written out to disk.

The new file in disk now contains a sorted list of the numbers supplied in the initial input file.


Merge sort
Merge sort is a divide-and-conquer algorithm based on the idea of breaking down a list into several sub-lists until each sublist consists of a single element and merging those sublists in a manner that results into a sorted list.

Idea:

Divide the unsorted list into  sublists, each containing  element.
Take adjacent pairs of two singleton lists and merge them to form a list of 2 elements.  will now convert into  lists of size 2.
Repeat the process till a single sorted list of obtained.
While comparing two sublists for merging, the first element of both lists is taken into consideration. While sorting in ascending order, the element that is of a lesser value becomes a new element of the sorted list. This procedure is repeated until both the smaller sublists are empty and the new combined sublist comprises all the elements of both the sublists.

Let’s consider the following image

enter image description here

As one may understand from the image above, at each step a list of size  is being divided into  sublists of size , until no further division can be done. To understand better, consider a smaller array  containing the elements .

At the first step this list of size  is divided into  sublists the first consisting of elements  and the second one being . Now, the first list consisting of elements  is further divided into  sublists consisting of elements  and  respectively.

As no further breakdown of this list can be done, as each sublist consists of a maximum of  element, we now start to merge these lists. The  sub-lists formed in the last step are then merged together in sorted order using the procedure mentioned above leading to a new list . Backtracking further, we then need to merge the list consisting of element  too with this list, leading to the new sorted list .

Java code:
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class ExternalSort {
	static int N = 2000000; // size of the file in disk
	static int M = 100000; // max items the memory buffer can hold

	public static void externalSort(String fileName) {
		String tfile = "temp-file-";
		int[] buffer = new int[M < N ? M : N];

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int slices = (int) Math.ceil((double) N / M);

			int i, j;
			i = j = 0;
			// Iterate through the elements in the file
			for (i = 0; i < slices; i++) {
				// Read M-element chunk at a time from the file
				for (j = 0; j < (M < N ? M : N); j++) {
					String t = br.readLine();
					if (t != null)
						buffer[j] = Integer.parseInt(t);
					else
						break;
				}
				// Sort M elements
				Arrays.sort(buffer);

				// Write the sorted numbers to temp file
				FileWriter fw = new FileWriter(tfile + Integer.toString(i) + ".txt");
				PrintWriter pw = new PrintWriter(fw);
				for (int k = 0; k < j; k++)
					pw.println(buffer[k]);

				pw.close();
				fw.close();
			}

			br.close();
			fr.close();

			// Now open each file and merge them, then write back to disk
			int[] topNums = new int[slices];
			BufferedReader[] brs = new BufferedReader[slices];

			for (i = 0; i < slices; i++) {
				brs[i] = new BufferedReader(new FileReader(tfile + Integer.toString(i) + ".txt"));
				String t = brs[i].readLine();
				if (t != null)
					topNums[i] = Integer.parseInt(t);
				else
					topNums[i] = Integer.MAX_VALUE;
			}

			FileWriter fw = new FileWriter("E:\\test\\external-sorted.txt");
			PrintWriter pw = new PrintWriter(fw);

			for (i = 0; i < N; i++) {
				int min = topNums[0];
				int minFile = 0;

				for (j = 0; j < slices; j++) {
					if (min > topNums[j]) {
						min = topNums[j];
						minFile = j;
					}
				}

				pw.println(min);
				String t = brs[minFile].readLine();
				if (t != null)
					topNums[minFile] = Integer.parseInt(t);
				else
					topNums[minFile] = Integer.MAX_VALUE;

			}
			for (i = 0; i < slices; i++)
				brs[i].close();

			pw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String generateInput(int n) {
		String fileName = "external-sort.txt";
		Random rand = new Random();

		try {
			FileWriter fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);

			for (int i = 0; i < n; i++)
				pw.println(rand.nextInt(101));

			pw.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return fileName;
	}

	public static void main(String[] args) {
		String fileName = generateInput(N);
		externalSort(fileName);
	}
}
