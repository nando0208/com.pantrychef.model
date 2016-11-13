package com.pantrychef.postgresql;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.SerializationException;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

//based on https://github.com/pires/hibernate-postgres-jsonb/
public class JsonStringType implements ParameterizedType, UserType {
    private static final String JSONB_TYPE = "jsonb";

    @Override
    public Class<Object> returnedClass() {
        return Object.class;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor session,
                              Object owner) throws HibernateException, SQLException {

        final String json = resultSet.getString(names[0]);
        return json;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
            throws HibernateException, SQLException {
        final String json = (String) value;
        // otherwise PostgreSQL won't recognize the type
        PGobject pgo = new PGobject();
        pgo.setType(JSONB_TYPE);
        pgo.setValue(json);
        st.setObject(index, pgo);
    }

    @Override
    public void setParameterValues(Properties parameters) {

    }

    // imuutable
    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if ((x == null) || (y == null)) {
            return false;
        }
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        assert (x != null);
        return x.hashCode();
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        // also safe for mutable objects
        return deepCopy(cached);
    }

    /**
     * Disassembles the object in preparation for serialization. See
     * {@link org.hibernate.usertype.UserType#disassemble(java.lang.Object)}.
     * <p>
     * Expects {@link #deepCopy(Object)} to return a {@code Serializable}. <strong>Subtypes whose
     * {@code deepCopy} implementation returns a non-serializable object must override this
     * method.</strong>
     */
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        // also safe for mutable objects
        Object deepCopy = deepCopy(value);

        if (!(deepCopy instanceof Serializable)) {
            throw new SerializationException(String.format("deepCopy of %s is not serializable", value),
                    null);
        }

        return (Serializable) deepCopy;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        // also safe for mutable objects
        return deepCopy(original);
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {

        return value;
    }
}
