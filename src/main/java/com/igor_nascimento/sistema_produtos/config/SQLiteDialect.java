package com.igor_nascimento.sistema_produtos.config;
/**
 * IMPORTANTE: Por que este arquivo existe?
 *
 * O Hibernate, por padrão, não oferece suporte oficial completo ao banco de dados SQLite,
 * pois o SQLite possui particularidades e limitações em relação a outros bancos relacionais
 * como PostgreSQL, MySQL ou Oracle. Por exemplo, o SQLite não implementa todos os tipos de dados,
 * comandos DDL ou funções SQL que o Hibernate espera encontrar em bancos tradicionais.
 *
 * Para que a aplicação Java consiga usar o Hibernate com SQLite de forma estável e previsível,
 * é necessário criar um "dialeto" customizado. O dialeto é uma classe que informa ao Hibernate
 * como traduzir operações e tipos SQL genéricos para comandos e tipos específicos do SQLite.
 *
 * Este arquivo define o dialeto customizado para SQLite, sobrescrevendo métodos essenciais
 * para garantir que:
 *   - O Hibernate gere SQL compatível com o SQLite;
 *   - Tipos de dados, auto-incremento, funções e limitações do SQLite sejam respeitados;
 *   - Operações não suportadas pelo SQLite sejam tratadas corretamente (ex: FOR UPDATE, CASCADE DELETE);
 *   - O Hibernate saiba como obter o último ID inserido, criar tabelas temporárias, etc.
 *
 * Sem este arquivo, a integração entre Hibernate e SQLite pode gerar erros inesperados,
 * comportamentos incorretos ou até perda de dados, pois o Hibernate tentaria executar comandos
 * incompatíveis com o SQLite.
 *
 * Portanto, este dialeto é fundamental para garantir a compatibilidade e o funcionamento correto
 * do sistema de produtos usando Hibernate + SQLite.
 */

import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;

/**
 * Dialeto customizado para SQLite compatível com Hibernate 6.x/7.x
 * Permite que o Hibernate funcione corretamente com bancos SQLite.
 */
public class SQLiteDialect extends Dialect {

    // Construtor: define a versão mínima do SQLite suportada
    public SQLiteDialect() {
        super(DatabaseVersion.make(3, 32)); // SQLite 3.32 ou superior
    }

    // Suporte a colunas de identidade (auto incremento)
    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        // Retorna uma implementação customizada para SQLite
        return new IdentityColumnSupportImpl() {
            // SQLite suporta colunas de identidade
            @Override
            public boolean supportsIdentityColumns() {
                return true;
            }

            // Comando SQL para obter o último ID inserido
            @Override
            public String getIdentitySelectString(String table, String column, int type) {
                return "select last_insert_rowid()";
            }

            // Tipo de coluna para auto incremento
            @Override
            public String getIdentityColumnString(int type) {
                return "integer";
            }
        };
    }

    // SQLite não suporta esquemas (schema), apenas nomes simples de tabela
    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }

    // Suporte ao uso de IF EXISTS antes do nome da tabela
    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    // Não suporta IF EXISTS depois do nome da tabela
    @Override
    public boolean supportsIfExistsAfterTableName() {
        return false;
    }

    // Não suporta exclusão em cascata
    @Override
    public boolean supportsCascadeDelete() {
        return false;
    }

    // Suporte a tabelas temporárias
    @Override
    public boolean supportsTemporaryTables() {
        return true;
    }

    // Métodos removidos pois não existem mais ou mudaram de assinatura

    // SQLite não suporta cláusula FOR UPDATE
    @Override
    public String getForUpdateString() {
        return "";
    }

    // Suporte à operação UNION ALL
    @Override
    public boolean supportsUnionAll() {
        return true;
    }

    // Suporte à seleção do timestamp atual
    @Override
    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    // O comando de timestamp atual não é invocável como função
    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    // Comando SQL para obter o timestamp atual
    @Override
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }
}
