import React, { useEffect, useState, useRef } from 'react';
import { io } from 'socket.io-client';

const SOCKET_URL = "http://localhost:4000";

export default function Chat(){
  const [username, setUsername] = useState('');
  const [connected, setConnected] = useState(false);
  const [messages, setMessages] = useState([]);
  const [text, setText] = useState('');
  const socketRef = useRef(null);
  const messagesRef = useRef(null);

  useEffect(() => {
    socketRef.current = io(SOCKET_URL);

    socketRef.current.on('connect', () => {
      // console.log('connected', socketRef.current.id);
    });

    socketRef.current.on('message', (data) => {
      setMessages((m) => [...m, { type: 'user', ...data }]);
    });

    socketRef.current.on('systemMessage', (data) => {
      setMessages((m) => [...m, { type: 'system', ...data }]);
    });

    return () => {
      socketRef.current.disconnect();
    };
  }, []);

  useEffect(() => {
    if(messagesRef.current){
      messagesRef.current.scrollTop = messagesRef.current.scrollHeight;
    }
  }, [messages]);

  const handleJoin = () => {
    if(!username) return;
    socketRef.current.emit('join', username);
    setConnected(true);
  };

  const sendMessage = () => {
    if(!text) return;
    const payload = {
      username: username || 'Anonymous',
      message: text,
      time: new Date().toLocaleTimeString()
    };
    socketRef.current.emit('message', payload);
    setMessages((m) => [...m, { type: 'user', ...payload }]);
    setText('');
  };

  return (
    <div style={{ border: '2px solid #111', padding: '10px', width: '380px', boxSizing: 'border-box' }}>
      <h3 style={{ textAlign: 'center' }}>Real-Time Chat</h3>
      <input
        placeholder="Enter name"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
        style={{ width: '100%', padding: '8px', marginBottom: '8px' }}
        disabled={connected}
      />
      {!connected ? (
        <button onClick={handleJoin} style={{ width: '100%', padding: '8px', marginBottom: '8px' }}>Join Chat</button>
      ) : null}
      <div ref={messagesRef} style={{ height: '300px', overflowY: 'auto', border: '1px solid #ccc', padding: '8px', marginBottom: '8px' }}>
        {messages.map((m, idx) => (
          <div key={idx} style={{ marginBottom: '6px' }}>
            {m.type === 'system' ? (
              <em>{m.message}</em>
            ) : (
              <strong>{m.username} [{m.time}]:</strong>
            )}
            {m.type === 'user' ? <span> {m.message}</span> : null}
          </div>
        ))}
      </div>
      <input
        placeholder="Type your message..."
        value={text}
        onChange={(e) => setText(e.target.value)}
        style={{ width: '100%', padding: '8px', marginBottom: '8px' }}
        onKeyDown={(e) => { if(e.key === 'Enter') sendMessage(); }}
        disabled={!connected}
      />
      <button onClick={sendMessage} style={{ width: '100%', padding: '8px' }} disabled={!connected}>Send</button>
    </div>
  );
}
