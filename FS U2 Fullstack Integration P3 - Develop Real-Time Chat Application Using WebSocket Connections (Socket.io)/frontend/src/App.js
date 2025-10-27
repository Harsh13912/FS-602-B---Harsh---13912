import React from 'react';
import Chat from './components/Chat';

export default function App(){
  return (
    <div style={{ display: 'flex', justifyContent: 'center', gap: '40px', padding: '20px' }}>
      <Chat />
      <Chat />
    </div>
  );
}
