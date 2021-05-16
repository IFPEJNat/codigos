
public class BubbleSort implements SortingStrategy {

    @Override
    public void sort(int array[])
    {
        long start = System.currentTimeMillis();
        int i, temp;
        int size = array.length;

	while (size>0)
        {
            for(i=0; i<size-1 ; i++)
            {
                if(array[i] > array[i+1])
                {
                    temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                }
            }
 	size--;
	}   
        
        System.out.println("Ordenado com BubbleSort");
        for(int j=0; j<array.length; j++)
        {
            System.out.print( array[j] + " ");
        }
        System.out.println();
        System.out.print("Tempo: ");
        System.out.print(System.currentTimeMillis()-start);
        System.out.print("ms");
        System.out.println();
    }
}
