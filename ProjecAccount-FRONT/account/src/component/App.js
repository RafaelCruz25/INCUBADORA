import React from 'react';

import { BrowserRouter, Route, Switch } from 'react-router-dom';

// import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootswatch/dist/cerulean/bootstrap.css';
import './App.css';

import NewAccount from '../pages/account/NewAccount';
import ListAccounts from '../pages/account/ListAccounts';
import EditAccount from '../pages/account/EditAccounts';
import WithdrawAccount from '../pages/account/WithdrawAccount';
import DepositAccount from '../pages/account/DepositAccount';
import NotFound from '../pages/NotFound';


const App = () =>
  <div className="container">
    <BrowserRouter>
      <Switch>
        <Route path={["/", "/accounts"]} exact component={ ListAccounts }/>
        <Route path="/accounts/new" exact component={ NewAccount}/>
        <Route path="/accounts/withdraw/:id" exact component={ WithdrawAccount}/>
        <Route path="/accounts/deposit/:id" exact component={DepositAccount}/>
        <Route path="/accounts/edit/:id" exact component={ EditAccount }/>
        <Route path="*" component={NotFound}/>
      </Switch>
    </BrowserRouter>
  </div>

export default App;
