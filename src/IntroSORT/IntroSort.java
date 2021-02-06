package IntroSORT;


public class IntroSort {
    // the actual data that has to be sorted
    private int a[];

    // the number of elements in the data
    private int n;

    // Constructor to initialize the size
    // of the data
    IntroSort(int n)
    {
        a = new int[n];
        this.n = 0;
    }

    // The utility function to insert the data
    public void dataAppend(int temp)
    {
        a[n] = temp;
        n++;
    }

    // The utility function to swap two elements
    private void swap(int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        GlobalItems.COMPAR++;
    }

    //Чтобы maxHeap поддерево укоренилось в узле i,
    // который является индексом в a[]. heapN - размер кучи
    private void maxHeap(int i, int heapN, int begin)
    {
        int temp = a[begin + i - 1];
        int child;

        while (i <= heapN / 2) {
            child = 2 * i;

            if (child < heapN&& a[begin + child - 1] < a[begin + child]){
                child++;
                //GlobalItems.COPY++;
                //GlobalItems.COMPAR++;
            }


            if (temp >= a[begin + child - 1]){
                //GlobalItems.COMPAR++;
                break;

            }
            a[begin + i - 1] = a[begin + child - 1];
            i = child;
            GlobalItems.COPY++;
        }
        a[begin + i - 1] = temp;
        GlobalItems.COPY++;
    }

    // Функция для построения кучи (перестановка массива)
    private void heapify(int begin, int end, int heapN)
    {
        for (int i = (heapN) / 2; i >= 1; i--)
            maxHeap(i, heapN, begin);
    }

    //Основная функция, чтобы сделать heapsort
        private void heapSort(int begin, int end)
        {
            int heapN = end - begin;
            GlobalItems.COPY++;
            //Сборка кучи (переставить массив)
            this.heapify(begin, end, heapN);

            //Один за другим извлеките элемент из кучи
            for (int i = heapN; i >= 1; i--) {

                //Переместить текущий корень в конец
                swap(begin, begin + i);

                //вызовите maxHeap () для уменьшенной кучи
                maxHeap(1, i, begin);

            }
    }

    //функция, которая реализует сортировку вставки
    private void insertionSort(int left, int right)
    {

        for (int i = left; i <= right; i++) {
            int key = a[i];
            int j = i;

            // Переместить элементы arr [0..i-1], которые больше ключа, на одну позицию вперед
            //их текущей позиции
            while (j > left && a[j - 1] > key) {
                a[j] = a[j - 1];
                j--;
                //GlobalItems.COMPAR++;
                GlobalItems.COPY++;
            }
            a[j] = key;
            GlobalItems.COPY++;
            GlobalItems.COMPAR++;
        }
    }

    //Функция для нахождения медианы трех элементов
    private int findPivot(int a1, int b1, int c1)
    {
        int max = Math.max(Math.max(a[a1], a[b1]), a[c1]);
        int min = Math.min(Math.min(a[a1], a[b1]), a[c1]);
        int median = max ^ min ^ a[a1] ^ a[b1] ^ a[c1];
        if (median == a[a1]){
            GlobalItems.COMPAR++;
            return a1;
        }
        if (median == a[b1]){
            GlobalItems.COMPAR++;
            return b1;
        }
        GlobalItems.COMPAR++;
        GlobalItems.COPY++;
        GlobalItems.COPY++;
        GlobalItems.COPY++;
        return c1;

    }

    //Эта функция принимает последний элемент в качестве точки поворота,
    // помещает элемент точки поворота в правильное положение в отсортированном массиве
    // и размещает все меньшие (меньше, чем точки поворота) слева от точки поворота,
    // а элементы большего размера справа от точки поворота.
    private int partition(int low, int high)
    {
        //стержень
        int pivot = a[high];
        //Индекс меньшего элемента
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {

            // Если текущий элемент меньше
            // чем или равно оси
            if (a[j] <= pivot) {

                //индекс приращения меньшего элемента
                i++;
                swap(i, j);
                //GlobalItems.COMPAR++;
            }
        }
        swap(i + 1, high);
        return (i + 1);
    }

    // Основная функция, которая реализует
    // Introsortlow -> Начальный индекс,
    // high -> Конечный индекс,
    // deepLimit -> Уровень рекурсии
    private void sortDataUtil(int begin, int end, int depthLimit)
    {
        if (end - begin > 16) {
            if (depthLimit == 0) {

                // если предел рекурсии обнаружен, то вызывается сортировка кучи
                this.heapSort(begin, end);
                return;
            }

            depthLimit = depthLimit - 1;
            int pivot = findPivot(begin,begin + ((end - begin) / 2) + 1, end);
            swap(pivot, end);

            //p - индекс разбиения,
            // arr [p] теперь в нужном месте
            int p = partition(begin, end);

            //Отдельная сортировка элементов перед разделом и после раздела
            sortDataUtil(begin, p - 1, depthLimit);
            sortDataUtil(p + 1, end, depthLimit);

        }

        else {
            // если набор данных небольшой, вставьте вызов сортировки
            insertionSort(begin, end);
        }
    }

    //Вспомогательная функция для запуска модуля Introsort
    public void sortData()
    {

        // Инициализируйте deepLimit как 2 * log (длина (данные))
        int depthLimit = (int)(2 * Math.floor(Math.log(n) / Math.log(2)));
        GlobalItems.COPY++;
        this.sortDataUtil(0, n - 1, depthLimit);
    }

    //Утилита для печати данных массива
    public void printData()
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
