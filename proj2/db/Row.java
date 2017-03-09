package db;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.io.Serializable;

    /**Implement the classes to manage rows, namely row, rowDesc. We have already implemented column, IntColumn, StringColumn, and Type for you.
     * Since you only need to support integer and (fixed length) string columns and fixed length rows, these are straightforward.
     Implement the Catalog (this should be very simple).
     Implement the BufferPool constructor and the getPage() method.
     Implement the access methods, HeapPage and HeapFile and associated ID classes. A good portion of these files has already been written for you.
     Implement the operator SeqScan.
     At this point, you should be able to pass the ScanTest system test, which is the goal for this lab.
     Section 2 below walks you through these implementation steps and the unit tests corresponding to each one in more detail.

     * row maintains information about the contents of a row. rows have a
     * specified schema specified by a rowDesc object and contain column objects
     * with the data for each column.
     */
    public class Row implements Serializable {


        public final RowDesc schema;
        public List<Column> RowList = new ArrayList<Column>();

        /**
         * Create a new row with the specified schema (type).
         *
         * @param rd
         *            the schema of this row. It must be a valid rowDesc
         *            instance with at least one column.
         */
        public Row(RowDesc rd) {
            // some code goes here
          this.schema = rd;
          for(int i = 0; i < rd.rdItemList.size(); i++){
              if(rd.rdItemList.get(i).columnType == Type.INT){
                  IntColumn intCol = new IntColumn();
                  RowList.add(intCol);
              }else if(rd.rdItemList.get(i).columnType == Type.STRING){
                  StringColumn strCol = new StringColumn();
                  RowList.add(strCol);
              }
          }
        }




//        public IntColumn(int i) {
//            value = i;
//        }
//        public StringColumn(String s, int maxSize) {
//            this.maxSize = maxSize;
//
//            if (s.length() > maxSize)
//                value = s.substring(0, maxSize);
//            else
//                value = s;
//        }


        /**
         * @return The rowDesc representing the schema of this row.
         */
        public RowDesc getrowDesc() {
            // some code goes here
            return this.schema;
        }

        /**
         * @return The RecordId representing the location of this row on disk. May
         *         be null.
         */
//        public RecordId getRecordId() {
//            // some code goes here
//            return null;
//        }
//
//        /**
//         * Set the RecordId information for this row.
//         *
//         * @param rid
//         *            the new RecordId for this row.
//         */
//        public void setRecordId(RecordId rid) {
//            // some code goes here
//        }

        /**
         * Change the value of the ith column of this row.
         *
         * @param i
         *            index of the column to change. It must be a valid index.
         * @param c
         *            new value for the column.
         */
        public void setColumn(int i, Column c) {
            // some code goes here
            if(i < 0 || i > schema.rdItemList.size()){
                throw new IllegalArgumentException("invalid index");
            }else{
                this.RowList.set(i,c);
            }
        }

        /**
         * @return the value of the ith column, or null if it has not been set.
         *
         * @param i
         *            column index to return. Must be a valid index.
         */
        public Column getColumn(int i) {
            // some code goes here
            if(i < 0 || i > schema.rdItemList.size()){
                throw new IllegalArgumentException("invalid index");
            } else {
                return this.RowList.get(i);
            }
        }

        /**
         * Returns the contents of this row as a string. Note that to pass the
         * system tests, the format needs to be as follows:
         *
         * 'Maurice','Lee','Steelers'
         * 'New York',2015,1
         *
         * where \t is any whitespace, except newline, and \n is a newline
         */
        public String toString() {
            // some code goes here
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < RowList.size(); i++){
                if (this.RowList.get(i).getType() == Type.INT){
                    sb.append(this.RowList.get(i));
                    sb.append(",");
                }else if(this.RowList.get(i).getType() == Type.STRING){
                    sb.append("'");
                    sb.append(this.RowList.get(i);)
                    sb.append("'");
                    sb.append(",");
                }
            }
            return sb.toString();
        }



        /**
         * @return
         *        An iterator which iterates over all the columns of this row
         * */
        public Iterator<Column> columns(){
            // some code goes here
            return null;
        }

        /**
         * reset the rowDesc of thi row
         * */
        public void resetRowDesc(RowDesc td)
        {
            // so
            // me code goes here

        }
    }

