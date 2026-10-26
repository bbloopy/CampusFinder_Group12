public class listStruc<T> {
    Object[] data;
    int size;

    public listStruc() {
        data = new Object[10];
        size = 0;
    }

    void add(T item) {
        if (size == data.length) {
            resize();
        }
        data[size] = item;
        size++;
    }

    void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @SuppressWarnings("unchecked")
    T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return null;
        }
        return (T) data[index];
    }

    void set(int index, T item) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }
        data[index] = item;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean contains(T item) {
        return indexOf(item) != -1;
    }

    int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (data[i] != null && data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    void remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            System.out.println("Item not found");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }
}