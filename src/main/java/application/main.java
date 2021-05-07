package application;

import com.opencsv.CSVReader;
import db.DB;
import model.dao.DaoFactory;
import model.dao.entities.*;
import model.dao.impl.*;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


public class main {
    public static void main(String[] args) {

        String csvFilePath = "src/main/resources/DADOS_ABERTOS_MEDICAMENTOS.csv";
        CSVReader csvReader = null;

        CategoriaRegulatoriaDaoJDBC categoriaRegulatoriaDaoJDBC = DaoFactory.createCRD();
        ClasseTerapeuticaDaoJDBC classeTerapeuticaDaoJDBC = DaoFactory.createCTD();
        EmpresaDetentoraDaoJDBC empresaDetentoraDaoJDBC = DaoFactory.createEDD();
        ProdutoDaoJDBC produtoDaoJDBC = DaoFactory.createPD();
        RegistroMedicamentoDaoJDBC registroMedicamentoDaoJDBC = DaoFactory.createRMD();
        RegistroMedicamentoProcessoDaoJDBC registroMedicamentoProcessoDaoJDBC = DaoFactory.createRMDP();
        TipoProdutoDaoJDBC tipoProdutoDaoJDBC = DaoFactory.createTPD();

        try {
            csvReader = new CSVReader(new InputStreamReader(new FileInputStream(csvFilePath), "windows-1252"), ';', '"', 1);
            String[] tblDetails = null;
            tblDetails = csvReader.readNext();
            List<String>  verRep = new ArrayList<>();
            CategoriaRegulatoria cr = new CategoriaRegulatoria(null);
            ClasseTerapeutica ct = new ClasseTerapeutica(null);
            EmpresaDetentora ed = new EmpresaDetentora();
            TipoProduto tp = new TipoProduto(null);
            Produto p;
            RegistroMedicamento rm;
            RegistroMedicamentoProcesso rmp;

            while ((tblDetails = csvReader.readNext()) != null) {

                if (!verRep.contains(tblDetails[3]) &&  !tblDetails[3].equals("")){
                    cr = new CategoriaRegulatoria(tblDetails[3]);
                    verRep.add(cr.getDesc_categoria());
                    categoriaRegulatoriaDaoJDBC.insert(cr);
                }
                if(!verRep.contains(tblDetails[7]) && !tblDetails[7].equals("")){
                    ct = new ClasseTerapeutica(tblDetails[7]);
                    verRep.add(ct.getClasse_terapeutica());
                    classeTerapeuticaDaoJDBC.insert(ct);
                }
                if(!verRep.contains(tblDetails[8]) && !tblDetails[8].equals("")){
                    ed = new EmpresaDetentora(tblDetails[8]);
                    verRep.add(ed.getRazao_social_detentora());
                    empresaDetentoraDaoJDBC.insert(ed);
                }
                if(!verRep.contains(tblDetails[0]) && !tblDetails[0].equals("")){
                    tp = new TipoProduto(tblDetails[0]);
                    verRep.add(tp.getTipo_produto());
                    tipoProdutoDaoJDBC.insert(tp);
                }
                p = new Produto(tblDetails[1], ct.getNumero_classe_terapeutica(), tp.getNumero_tipo_produto());
                produtoDaoJDBC.insert(p);

                rm = new RegistroMedicamento(Long.parseLong(tblDetails[4].trim()), p.getNumero_produto(), tblDetails[5], tblDetails[9]);
                registroMedicamentoDaoJDBC.insert(rm);

                rmp = new RegistroMedicamentoProcesso(rm.getNumero_registro_produto(), Long.parseLong(tblDetails[6]), tblDetails[2], cr.getNumero_categoria_regulatoria(), ed.getCnpj_detentora());
                registroMedicamentoProcessoDaoJDBC.insert(rmp);
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            DB.closeConnection();
        }
    }
}
