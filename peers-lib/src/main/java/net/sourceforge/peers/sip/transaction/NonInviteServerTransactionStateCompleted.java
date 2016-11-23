/*
    This file is part of Peers, a java SIP softphone.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
    Copyright 2007, 2008, 2009, 2010 Yohann Martineau 
*/

package net.sourceforge.peers.sip.transaction;

import org.slf4j.Logger;

public class NonInviteServerTransactionStateCompleted extends
        NonInviteServerTransactionState {

    public NonInviteServerTransactionStateCompleted(String id,
            NonInviteServerTransaction nonInviteServerTransaction,
            Logger logger) {
        super(id, nonInviteServerTransaction, logger);
    }

    @Override
    public void timerJFires() {
        NonInviteServerTransactionState nextState = nonInviteServerTransaction.TERMINATED;
        nonInviteServerTransaction.setState(nextState);
    }
    
    @Override
    public void transportError() {
        NonInviteServerTransactionState nextState = nonInviteServerTransaction.TERMINATED;
        nonInviteServerTransaction.setState(nextState);
    }
    
    @Override
    public void receivedRequest() {
        NonInviteServerTransactionState nextState = nonInviteServerTransaction.COMPLETED;
        nonInviteServerTransaction.setState(nextState);
        nonInviteServerTransaction.sendLastResponse();
    }
    
}
