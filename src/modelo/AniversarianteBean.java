
package modelo;


public class AniversarianteBean {
   
 private String nome;
 private String cargo;
 private String telefone1;
 private String bairro;
 private String email;
 private String data_de_nasc;
 private byte[]foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_de_nasc() {
        return data_de_nasc;
    }

    public void setData_de_nasc(String data_de_nasc) {
        this.data_de_nasc = data_de_nasc;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
 
}
