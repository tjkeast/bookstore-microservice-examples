const API_URL = 'http://localhost:8080';

module.exports = [
	{
		context: ['/api'],
		pathRewrite: {
			'^/api': '/'
		},
		target: API_URL,
		secure: false,
		changeOrigin: true,
		autoRewrite: true
	}
];
