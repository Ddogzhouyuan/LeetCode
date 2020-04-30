import java.util.Iterator;
import java.util.NoSuchElementException;

public class lc284_PeekingIterator {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {

        Integer next;
        Iterator<Integer> iter;
        boolean noSuchElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
            advanceIter();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (noSuchElement) {
                return null;
            }
            Integer res = next;
            advanceIter();
            return res;
        }

        @Override
        public boolean hasNext() {
            return !noSuchElement;
        }

        private void advanceIter() {
            if (iter.hasNext()) {
                next = iter.next();
            } else {
                noSuchElement = true;
            }
        }
    }
}
