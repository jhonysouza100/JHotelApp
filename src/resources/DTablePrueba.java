package resources;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DTable extends JTable{

@Override
public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex){
 Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
 component.setBackground(Color.BLACK);
 component.setForeground(Color.WHITE);

 if((Float.class.equals(this.getColumnClass(columnIndex))) && (getValueAt(rowIndex, columnIndex)!=null)){//validamos que la columna sea de tipo float y que la selda no sea null
  float val = Float.parseFloat(getValueAt(rowIndex, columnIndex).toString()); //recuperamos el valor de la selda

  if(val<0){//validacion para valores menor a 0
    component.setBackground(Color.YELLOW);
    component.setForeground(Color.RED);
   }
 }
 return component;

}

}