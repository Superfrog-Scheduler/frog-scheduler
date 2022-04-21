export default [
    {
      url: '/api/profile',
      method: 'get',
      response: () => {
        return {
          code: 200,
          message: 'Request success',
          type: 'success',
          result: {
            name: 'John Doe',
            email: 'john.doe123@gmail.com',
            role: 'team',
          },
        };
      },
    },
    {
      url: '/api/auth/login',
      method: 'post',
      timeout: 2000,
      response: () => {
        return {
          code: 200,
          message: 'Login success',
          type: 'success',
          result: {
            token: 'ABCDEFG123oi*&',
          },
        };
      },
    },
  ];
  