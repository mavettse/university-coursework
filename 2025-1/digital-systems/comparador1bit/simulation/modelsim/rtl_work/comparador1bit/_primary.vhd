library verilog;
use verilog.vl_types.all;
entity comparador1bit is
    port(
        LEDR            : out    vl_logic_vector(17 downto 0);
        SW              : in     vl_logic_vector(17 downto 0)
    );
end comparador1bit;
