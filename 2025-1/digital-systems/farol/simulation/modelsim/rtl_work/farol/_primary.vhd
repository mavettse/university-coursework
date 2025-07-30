library verilog;
use verilog.vl_types.all;
entity farol is
    port(
        f               : in     vl_logic;
        p               : in     vl_logic;
        c               : in     vl_logic;
        s               : out    vl_logic
    );
end farol;
