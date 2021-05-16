import java.util.Random;

public class SortingProgram 
{
    SortingStrategy sortingStrategy;

    public int [] array;

    public SortingProgram(int [] array){

            this.array= array;

    }

    public void runSort(SortingStrategy sortingStrategy)
    {
            sortingStrategy.sort(array);
    }


    public static void main(String[] args) {
            
            Random random = new Random();
         
            int[] array;
            array = new int [500];
                
            for(int i=0; i<500 ; i++)
            {
                array[i] = random.nextInt(1000);
            }
            
            SortingProgram sorting = new SortingProgram(array);
            
            System.out.println("Array desordenado:");
            
            for(int k=0; k<array.length; k++)
            {
                System.out.print( array[k] + " ");
            }
            
            System.out.println();
            
            sorting.runSort(new BubbleSort());
            sorting.runSort(new InsertionSort());
            sorting.runSort(new MergeSort());
            sorting.runSort(new QuickSort());
    }
}
	


