
package controle;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class LimiteTexto extends PlainDocument{

      int tam = 0;
      public LimiteTexto (int a){
          
      this.tam = a;
    
    }
   @ Override 
  public void insertString(int offs, String str, AttributeSet a)throws BadLocationException{
      
   int quantidadeMax = (this.getLength() + str.length());
   
   if (quantidadeMax <= tam){
    
    super.insertString(offs, str.replaceAll("[^aA-zZ-´`^~çÇâãõôêíÍéÉáÁúÚóÓ ^~.,;:_-]", ""), a);
    } 
   else{
      
      super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
}
 }   
}
