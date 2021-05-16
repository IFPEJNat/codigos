public class QuickSort implements SortingStrategy 
{
    @Override
    public void sort(int [] array)
    {
        long start = System.currentTimeMillis();
        int inicio = 0;
        int fim = (array.length)-1;
        
        quickSort(array, inicio, fim);
        
        System.out.println("Ordenado com QuickSort");
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
    
    private void quickSort(int[] array, int inicio, int fim) 
    {
        if (inicio < fim) 
        {
            int posicaoPivo = separar(array, inicio, fim);
            quickSort(array, inicio, posicaoPivo - 1);
            quickSort(array, posicaoPivo + 1, fim);
        }
    }
    private int separar(int[] array, int inicio, int fim) 
    {
        int pivo = array[inicio];
        int i = inicio + 1, f = fim;
        
        while (i <= f) 
        {
            if (array[i] <= pivo)
                i++;
            else if (pivo < array[f])
                f--;
            else 
            {
                int troca = array[i];
                array[i] = array[f];
                array[f] = troca;
                i++;
                f--;
            }
        }
    
        array[inicio] = array[f];
        array[f] = pivo;
    return f;
    }      
}