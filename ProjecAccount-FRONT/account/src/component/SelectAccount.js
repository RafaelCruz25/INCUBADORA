import React from 'react';

const Select = ({ value, onChange}) =>
  {
    return( <>
      <label htmlFor="Account Type">Account Type</label>
      <select className="form-control" value={value} name="typeAccount" onChange={onChange}>
        <option value="">Selecione uma Conta</option>
        <option value="CHECKINGACCOUNT">Conta Corrente</option>
        <option value="SAVINGSACCOUNT"> Conta Poupança</option>
      </select><br/>
    </>);
  }

  export default Select;
