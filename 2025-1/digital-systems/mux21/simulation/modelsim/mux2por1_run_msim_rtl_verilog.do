transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/gioes/Documents/AtividadesSD/mux21 {C:/Users/gioes/Documents/AtividadesSD/mux21/mux2por1.v}

