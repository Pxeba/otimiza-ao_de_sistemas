
import org.gnu.glpk.GLPK;
import org.gnu.glpk.GLPKConstants;
import org.gnu.glpk.GlpkException;
import org.gnu.glpk.SWIGTYPE_p_double;
import org.gnu.glpk.SWIGTYPE_p_int;
import org.gnu.glpk.glp_prob;
import org.gnu.glpk.glp_smcp;

public class Modelo {
    /*
    obj: Minimize x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9 + x10

    x1 >= 0
    x1 >= 0
    x3 >= 0
    x4 >= 0
    x5 >= 0
    x6 >= 0
    x7 >= 0
    x8 >= 0 
    x9 >= 0
    x10 >= 0

    x2 + x3 + x4 >= 22
    x6 + x7 + x8 >= 25
    x5 >= 12
    x9 + 2*x10 >= 14
    3*x1 + x5 >= 18
    x6 + x9 >= 18
    x2 + x7 + x8 >= 20
    x9 >= 10
    x3 >= 12
    2*x4 >= 14
    x8 >= 16
    x2 + x3 + x7 + x10 >= 18
    x5 + x6 >= 20
    */

    public static void main(String[] arg) {
        glp_prob lp;
        glp_smcp parm;
        SWIGTYPE_p_int ind;
        SWIGTYPE_p_double val;
        int ret;

        try {
            // Create problem
            lp = GLPK.glp_create_prob();
            System.out.println("Problem created");
            GLPK.glp_set_prob_name(lp, "Cutting Stock Problem");

            // Define columns
            GLPK.glp_add_cols(lp, 10);
            GLPK.glp_set_col_name(lp, 1, "x1");
            GLPK.glp_set_col_kind(lp, 1, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 1, GLPKConstants.GLP_LO, 0, 0); //x1 >= 0
            GLPK.glp_set_col_name(lp, 2, "x2");
            GLPK.glp_set_col_kind(lp, 2, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 2, GLPKConstants.GLP_LO, 0, 0); //x2 >= 0
            GLPK.glp_set_col_name(lp, 3, "x3");
            GLPK.glp_set_col_kind(lp, 3, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 3, GLPKConstants.GLP_LO, 0, 0); //x3 >= 0
            GLPK.glp_set_col_name(lp, 4, "x4");
            GLPK.glp_set_col_kind(lp, 4, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 4, GLPKConstants.GLP_LO, 0, 0); //x4 >= 0
            GLPK.glp_set_col_name(lp, 5, "x5");
            GLPK.glp_set_col_kind(lp, 5, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 5, GLPKConstants.GLP_LO, 0, 0); //x5 >= 0
            GLPK.glp_set_col_name(lp, 6, "x6");
            GLPK.glp_set_col_kind(lp, 6, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 6, GLPKConstants.GLP_LO, 0, 0); //x6 >= 0
            GLPK.glp_set_col_name(lp, 7, "x7");
            GLPK.glp_set_col_kind(lp, 7, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 7, GLPKConstants.GLP_LO, 0, 0); //x7 >= 0
            GLPK.glp_set_col_name(lp, 8, "x8");
            GLPK.glp_set_col_kind(lp, 8, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 8, GLPKConstants.GLP_LO, 0, 0); //x8 >= 0
            GLPK.glp_set_col_name(lp, 9, "x9");
            GLPK.glp_set_col_kind(lp, 9, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 9, GLPKConstants.GLP_LO, 0, 0); //x9 >= 0
            GLPK.glp_set_col_name(lp, 10, "x10");
            GLPK.glp_set_col_kind(lp, 10, GLPKConstants.GLP_CV);
            GLPK.glp_set_col_bnds(lp, 10, GLPKConstants.GLP_LO, 0, 0); //x10 >= 0

            // Create constraints

            // Allocate memory
            ind = GLPK.new_intArray(4);
            val = GLPK.new_doubleArray(4);

            // Create rows
            GLPK.glp_add_rows(lp, 13);

            // Set row details
            GLPK.glp_set_row_name(lp, 1, "c1");
            GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_LO, 22, 0);
            GLPK.intArray_setitem(ind, 1, 2);
            GLPK.intArray_setitem(ind, 2, 3);
            GLPK.intArray_setitem(ind, 3, 4);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.glp_set_mat_row(lp, 1, 3, ind, val);

            GLPK.glp_set_row_name(lp, 2, "c2");
            GLPK.glp_set_row_bnds(lp, 2, GLPKConstants.GLP_LO, 25, 0);
            GLPK.intArray_setitem(ind, 1, 6);
            GLPK.intArray_setitem(ind, 2, 7);
            GLPK.intArray_setitem(ind, 3, 8);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.glp_set_mat_row(lp, 2, 3, ind, val);
            
            GLPK.glp_set_row_name(lp, 3, "c3");
            GLPK.glp_set_row_bnds(lp, 3, GLPKConstants.GLP_LO, 12, 0);
            GLPK.intArray_setitem(ind, 1, 5);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.glp_set_mat_row(lp, 3, 1, ind, val);

            GLPK.glp_set_row_name(lp, 4, "c4");
            GLPK.glp_set_row_bnds(lp, 4, GLPKConstants.GLP_LO, 14, 0);
            GLPK.intArray_setitem(ind, 1, 9);
            GLPK.intArray_setitem(ind, 2, 10);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 2.);
            GLPK.glp_set_mat_row(lp, 4, 2, ind, val);

            GLPK.glp_set_row_name(lp, 5, "c5");
            GLPK.glp_set_row_bnds(lp, 5, GLPKConstants.GLP_LO, 18, 0);
            GLPK.intArray_setitem(ind, 1, 1);
            GLPK.intArray_setitem(ind, 2, 5);
            GLPK.doubleArray_setitem(val, 1, 3.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.glp_set_mat_row(lp, 5, 2, ind, val);

            GLPK.glp_set_row_name(lp, 6, "c6");
            GLPK.glp_set_row_bnds(lp, 6, GLPKConstants.GLP_LO, 18, 0);
            GLPK.intArray_setitem(ind, 1, 6);
            GLPK.intArray_setitem(ind, 2, 9);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.glp_set_mat_row(lp, 6, 2, ind, val);

            GLPK.glp_set_row_name(lp, 7, "c7");
            GLPK.glp_set_row_bnds(lp, 7, GLPKConstants.GLP_LO, 20, 0);
            GLPK.intArray_setitem(ind, 1, 2);
            GLPK.intArray_setitem(ind, 2, 7);
            GLPK.intArray_setitem(ind, 3, 8);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.glp_set_mat_row(lp, 7, 3, ind, val);

            GLPK.glp_set_row_name(lp, 8, "c8");
            GLPK.glp_set_row_bnds(lp, 8, GLPKConstants.GLP_LO, 10, 0);
            GLPK.intArray_setitem(ind, 1, 9);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.glp_set_mat_row(lp, 8, 1, ind, val);

            GLPK.glp_set_row_name(lp, 9, "c9");
            GLPK.glp_set_row_bnds(lp, 9, GLPKConstants.GLP_LO, 12, 0);
            GLPK.intArray_setitem(ind, 1, 3);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.glp_set_mat_row(lp, 9, 1, ind, val);

            GLPK.glp_set_row_name(lp, 10, "c10");
            GLPK.glp_set_row_bnds(lp, 10, GLPKConstants.GLP_LO, 14, 0);
            GLPK.intArray_setitem(ind, 1, 4);
            GLPK.doubleArray_setitem(val, 1, 2.);
            GLPK.glp_set_mat_row(lp, 10, 1, ind, val);

            GLPK.glp_set_row_name(lp, 11, "c11");
            GLPK.glp_set_row_bnds(lp, 11, GLPKConstants.GLP_LO, 16, 0);
            GLPK.intArray_setitem(ind, 1, 8);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.glp_set_mat_row(lp, 11, 1, ind, val);

            GLPK.glp_set_row_name(lp, 12, "c12");
            GLPK.glp_set_row_bnds(lp, 12, GLPKConstants.GLP_LO, 18, 0);
            GLPK.intArray_setitem(ind, 1, 2);
            GLPK.intArray_setitem(ind, 2, 3);
            GLPK.intArray_setitem(ind, 3, 7);
            GLPK.intArray_setitem(ind, 4, 10);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.doubleArray_setitem(val, 3, 1.);
            GLPK.doubleArray_setitem(val, 4, 1.);
            GLPK.glp_set_mat_row(lp, 12, 4, ind, val);

            GLPK.glp_set_row_name(lp, 13, "c13");
            GLPK.glp_set_row_bnds(lp, 13, GLPKConstants.GLP_LO, 20, 0);
            GLPK.intArray_setitem(ind, 1, 5);
            GLPK.intArray_setitem(ind, 2, 6);
            GLPK.doubleArray_setitem(val, 1, 1.);
            GLPK.doubleArray_setitem(val, 2, 1.);
            GLPK.glp_set_mat_row(lp, 13, 2, ind, val);

            // Free memory
            GLPK.delete_intArray(ind);
            GLPK.delete_doubleArray(val);

            // Define objective
            GLPK.glp_set_obj_name(lp, "z");
            GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MIN);
            GLPK.glp_set_obj_coef(lp, 1, 1.);
            GLPK.glp_set_obj_coef(lp, 2, 1.);
            GLPK.glp_set_obj_coef(lp, 3, 1.);
            GLPK.glp_set_obj_coef(lp, 4, 1.);
            GLPK.glp_set_obj_coef(lp, 5, 1.);
            GLPK.glp_set_obj_coef(lp, 6, 1.);
            GLPK.glp_set_obj_coef(lp, 7, 1.);
            GLPK.glp_set_obj_coef(lp, 8, 1.);
            GLPK.glp_set_obj_coef(lp, 9, 1.);
            GLPK.glp_set_obj_coef(lp, 10, 1.);

            // Write model to file
            // GLPK.glp_write_lp(lp, null, "lp.lp");

            // Solve model
            parm = new glp_smcp();
            GLPK.glp_init_smcp(parm);
            ret = GLPK.glp_simplex(lp, parm);

            // Retrieve solution
            if (ret == 0) {
                write_lp_solution(lp);
            } else {
                System.out.println("The problem could not be solved");
            }

            // Free memory
            GLPK.glp_delete_prob(lp);
        } catch (GlpkException ex) {
            ex.printStackTrace();
        ret = 1;
        }
    System.exit(ret);
    }

    /**
     * write simplex solution
     * @param lp problem
     */
    static void write_lp_solution(glp_prob lp) {
        int i;
        int n;
        String name;
        double val;

        name = GLPK.glp_get_obj_name(lp);
        val = GLPK.glp_get_obj_val(lp);
        System.out.print(name);
        System.out.print(" = ");
        System.out.println(val);
        n = GLPK.glp_get_num_cols(lp);
        for (i = 1; i <= n; i++) {
            name = GLPK.glp_get_col_name(lp, i);
            val = GLPK.glp_get_col_prim(lp, i);
            System.out.print(name);
            System.out.print(" = ");
            System.out.println(val);
        }
    }
}
