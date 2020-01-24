import React from 'react';

const Field =({ label, name, value, errors, onChange, type}) =>
    <div className="form-group">

        <label htmlFor={name}> {label} </label>
        <input type={type}
                name={name}
                className="form-control"
                value={value}
                onChange={onChange}/>
        <span className="form-text text-danger"> {errors}</span>
    </div>

Field.defaultProps ={
  type: 'text'
}

export default Field;
