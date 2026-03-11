package com.empresa.repository;

import com.empresa.connection.ConnectionFactory;
import com.empresa.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    public List<Funcionario> listarTodos() {

        String sql = "SELECT * FROM pessoas";

        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Funcionario funcionario = new Funcionario(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("email")
                );

                funcionarios.add(funcionario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    public Funcionario listarUm(String nome) {

        String sql = "SELECT * FROM pessoas WHERE nome ILIKE ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Funcionario funcionario = new Funcionario(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("email")
                );

                funcionario.setId(rs.getInt("id")); // IMPORTANTE

                return funcionario;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public void salvar(Funcionario funcionario) {

        String sql = """
                INSERT INTO pessoas (nome, idade, sexo, email)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setString(3, String.valueOf(funcionario.getSexo()));
            stmt.setString(4, funcionario.getEmail());

            stmt.executeUpdate();

            System.out.println("Funcionário salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Funcionario funcionario){

        String sql = """
        UPDATE pessoas
        SET nome = ?, idade = ?, sexo = ?, email = ?
        WHERE id = ?
        """;

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getIdade());
            stmt.setString(3, String.valueOf(funcionario.getSexo()));
            stmt.setString(4, funcionario.getEmail());
            stmt.setInt(5, funcionario.getId());

            stmt.executeUpdate();

            System.out.println("Funcionario atualizado!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deletar(String nome){

        String sql = "DELETE FROM pessoas WHERE nome = ?";

        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);

            stmt.executeUpdate();

            System.out.println("Funcionario excluido!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}