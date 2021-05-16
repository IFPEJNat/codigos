public class InsertionSort implements SortingStrategy 
{
    @Override
    public void sort(int [] array)
    {
        int j;
        int key;
        int i;
        long start = System.currentTimeMillis();
        for (j = 1; j < array.length; j++)
        {
            key = array[j];
            
            for (i = j - 1; (i >= 0) && (array[i] > key); i--)
            {
                array[i + 1] = array[i];
            }
            
            array[i + 1] = key;
        }
    
        System.out.println("Ordenado com InsertionSort");
        for(int k=0; k<array.length; k++)
        {
            System.out.print( array[k] + " ");
        }
        System.out.println();
        System.out.print("Tempo: ");
        System.out.print(System.currentTimeMillis()-start);
        System.out.print("ms");
        System.out.println();
    }
}