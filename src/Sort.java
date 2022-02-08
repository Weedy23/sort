import java.util.Random;
class Sort {
    int n=100;
    int numbers[] =new int[n];
    static int compare,exchange;
    public void init(){
        Random rand=new Random();
        for(int i=0; i<n; i++){
            numbers[i] = rand.nextInt(200);
        }
        compare=0;
        exchange=0;
    }

    public void output(){
        for(int i=0; i<n; i++){
            System.out.format("%4d",numbers[i]);
        }
        System.out.println();
    }

    public int min_place(){
        int place = 0;
        for(int i=1;i<n;i++) {
            if (numbers[place]<numbers[i])place=i;
        }
        return place;
    }

    public void swap(int i,int j){
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
        exchange++;
    }

    public static void outputCE(){
        System.out.println("Nr of changes="+exchange+" Nr of compares="+compare);
    }

    public void naivais(){
        for(int j=0;j<n-1;j++){
            int minPlace=j;
            for(int i=j+1;i<n;i++){
                if(numbers[minPlace]>numbers[i]){
                    minPlace=i;
                }
                compare++;
            }
            swap(minPlace,j);
        }
    }

    public void reversNaivais() {
        for(int j=0;j<n-1;j++){
            int maxPlace=j;
            for(int i=j+1;i<n;i++){
                if(numbers[maxPlace]<numbers[i]){
                    maxPlace=i;
                }
                compare++;
            }
            swap(maxPlace,j);
        }
    }

    public void burbulis() {
        for (int counter = 0; counter != n - 1;) {
            counter = 0;
            for (int i = 0; i < n - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swap(i, i + 1);
                } else {
                    counter++;
                }
                compare++;
            }
        }
    }

    public static void sort() {
        Sort sort=new Sort();
        sort.init();
        sort.output();
        sort.naivais();
        sort.output();
        sort.outputCE();
        sort.init();
        sort.output();
        exchange = 0;
        compare = 0;
        sort.reversNaivais();
        sort.output();
        sort.outputCE();
        exchange = 0;
        compare = 0;
        sort.init();
        sort.output();
        sort.burbulis();
        sort.output();
        sort.outputCE();
    }
}