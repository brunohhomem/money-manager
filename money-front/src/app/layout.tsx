import { cn } from '@/lib/utils'
import './globals.css'
import type { Metadata } from 'next'
import { Poppins } from 'next/font/google'

const poppins = Poppins({ weight: '300', subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'Money Manager :: Seu gerenciador financeiro',
  description: 'Gerenciador financeiro fullstack'
}

export default function RootLayout({
  children
}: Readonly<{
  children: React.ReactNode
}>) {
  return (
    <html lang="pr-BR">
      <body className={cn(poppins.className, 'bg-gray-100')}>{children}</body>
    </html>
  )
}
