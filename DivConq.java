import java.util.Arrays;

public class DivConq {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[] { 1, 2 })));
        System.out.println(Arrays.toString(mergeSort(new int[] { 3, 2, 1})));
        System.out.println(Arrays.toString(mergeSort(new int[] { 3, 1, 2})));
        System.out.println(Arrays.toString(mergeSort(new int[] { 1, 1, 2})));
    }

    public static int[] mergeSort(int[] valores) {
        if (valores.length == 1) {
            return valores;
        }
        final int HALVE = valores.length / 2;
        final int[] fHalve = mergeSort(Arrays.copyOfRange(valores, 0, HALVE));
        final int[] sHalve = mergeSort(Arrays.copyOfRange(valores, HALVE, valores.length));
        final int[] mergeArray = merge(fHalve, sHalve);

        return mergeArray;
    }

    public static int[] merge(int[] fArray, int[] sArray) {
        int[] result = new int[fArray.length + sArray.length];

        int fIndex, sIndex, rIndex;

        rIndex = 0;
        fIndex = 0;
        sIndex = 0;

        while (fIndex < fArray.length && sIndex < sArray.length) {
            if (fArray[fIndex] > sArray[sIndex]) {
                result[rIndex] = fArray[fIndex];
                fIndex++;
            } else if (sArray[sIndex] > fArray[fIndex]) {
                result[rIndex] = sArray[sIndex];
                sIndex++;
            } else {
                result[rIndex] = sArray[sIndex];
                rIndex++;
                result[rIndex] = fArray[fIndex];
                fIndex++;
                sIndex++;
            }
            rIndex++;
        }
        while(fIndex < fArray.length)
            result[rIndex++] = fArray[fIndex++];
        while(sIndex < sArray.length)
            result[rIndex++] = sArray[sIndex++];

        return result;
    }

}