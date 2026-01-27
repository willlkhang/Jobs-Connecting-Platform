/** @type {import('next').NextConfig} */
const nextConfig = {
  images: {
    remotePatterns: [
      {
        protocol: 'https',
        hostname: 'images.contentstack.io',
        port: '',
        pathname: '/**', // Allow all paths from this domain
      },
    ],
  },
};

export default nextConfig; // use 'module.exports = nextConfig' if using older CommonJS