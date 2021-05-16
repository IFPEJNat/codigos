public class MergeSort implements SortingStrategy 
{
    @Override
    
    public void sort(int [] array)
    {
        int size = array.length;
        long start = System.currentTimeMillis();
        mergeSort(size, array);
        
        System.out.println("Ordenado com MergeSort");
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

    private void mergeSort(int tamanho, int[] array) 
    {
        int elementos = 1;
        int inicio, meio, fim;
    
        while(elementos < tamanho) 
        {
            inicio = 0;
       
        while(inicio + elementos < tamanho) 
        {
            meio = inicio + elementos;
            fim = inicio + 2 * elementos;
        
            if(fim > tamanho)
                fim = tamanho;
        
        intercala(array, inicio, meio, fim);
       
        inicio = fim;
        }
        elementos = elementos * 2;
        }
    }
    
    private static void intercala(int[] vetor, int inicio, int meio, int fim) 
    {
        int novoVetor[] = new int[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;
    
        while(i < meio && m < fim) 
        {
            if(vetor[i] <= vetor[m]) 
            {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
            } 
            else 
            {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }
    
        while(i < meio) 
        {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }
    
        while(m < fim) 
        {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }
        
        for(pos = 0, i = inicio; i < fim; i++, pos++) 
        {
            vetor[i] = novoVetor[pos];
        }
    }
}