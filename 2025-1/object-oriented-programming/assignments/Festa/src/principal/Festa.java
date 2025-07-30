package principal;

public class Festa {
    private Cliente cliente;
    private String endereco;
    private ItemDeDecoracao tema;
    private String data;
    private String horaInicio;
    private String horaFinal;

    public Festa(Cliente cliente, String endereco, ItemDeDecoracao tema, String data, String horaInicio,
                 String horaFinal) {
        this.cliente = new Cliente(cliente);
        this.endereco = endereco;
        this.tema = new ItemDeDecoracao(tema);
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public Festa() {
        cliente = new Cliente();
        endereco = "";
        tema = new ItemDeDecoracao();
        data = "";
        horaInicio = "";
        horaFinal = "";
    }

    public Cliente getCliente() {
        return new Cliente(cliente);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = (cliente == null ? new Cliente() : new Cliente(cliente));
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ItemDeDecoracao getTema() {
        return new ItemDeDecoracao(tema);
    }

    public void setTema(ItemDeDecoracao tema) {
        this.tema = (tema == null ? new ItemDeDecoracao() : new ItemDeDecoracao(tema));
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
}
