const info = async () => {
    return await fetch('/api/profile').then((r) => r.json());
  };
  
  const login = async (loginInfo) => {
    return await fetch('/api/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(loginInfo),
    }).then((r) => r.json());
  };
  
  export default { info, login };
  